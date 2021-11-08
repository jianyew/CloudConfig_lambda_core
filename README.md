打包
安装配置 AWS CLI
安装
参考 AWS 命令行界面 安装
Win 下载 https://s3.amazonaws.com/aws-cli/AWSCLI64.msi 安装
Mac/Linux 执行 npm install awscli (首先初始化 node)

配置 AWS CLI
aws configure
输入 AWS Access Key ID  = （aws子账户id）
AWS Secret Access Key = （aws子账户密钥）
region name = ap-southeast-1（region ）

创建s3 储存通
aws s3 mb s3://cloudconfig-mydemo-app --region ap-southeast-1
进入项目根目录

本地打包
mvn package

cloudformation打包
aws cloudformation package --template-file sam.yaml --output-template-file output-sam.yaml --s3-bucket cloudconfig-mydemo-app

部署lambda函数
aws cloudformation deploy --template-file output-sam.yaml --stack-name cloudconfig-mydemo-app  --capabilities CAPABILITY_NAMED_IAM --region=ap-southeast-1

获取应用信息
aws cloudformation describe-stacks --stack-name cloudconfig-mydemo-app --region=ap-southeast-1



