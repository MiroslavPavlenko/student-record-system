############################
#  AWS provider            #
############################
provider "aws" {
  region     = "<YOUR_AWS_REGION>"       # e.g. "us‑east‑2"
  access_key = "<YOUR_ACCESS_KEY_ID>"    # or omit and use AWS profile / env‑vars
  secret_key = "<YOUR_SECRET_ACCESS_KEY>"
}

######################################
#  RDS MySQL instance: student_db    #
######################################
resource "aws_db_instance" "student_db" {
  identifier               = "<YOUR_DB_IDENTIFIER>"   # e.g. "student-db1-dev"
  engine                   = "mysql"
  instance_class           = "db.t3.micro"            # free‑tier eligible
  allocated_storage        = 20

  username                 = "<MASTER_USERNAME>"      # e.g. "admin"
  password                 = "<MASTER_PASSWORD>"      # supply via tfvars or secrets manager
  db_name                  = "<INITIAL_DATABASE>"     # e.g. "student_db"

  skip_final_snapshot      = true
  publicly_accessible      = true

  vpc_security_group_ids   = [aws_security_group.allow_mysql.id]
}

############################################
#  Security group to allow MySQL traffic   #
############################################
resource "aws_security_group" "allow_mysql" {
  name = "allow_mysql"

  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["<ALLOWED_CIDR_BLOCK>"]   # e.g. "123.45.67.89/32"  (avoid 0.0.0.0/0)
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
