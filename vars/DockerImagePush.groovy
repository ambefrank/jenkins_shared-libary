//def call(String project, String ImageTag, String hubUser){
//    withCredentials([usernamePassword(
//        credentialsId: 'docker', 
//        passwordVariable: 'PASS', 
//        usernameVariable: 'USER'
//    )]) {
//        sh "docker login -u '$USER' -p '$PASS'"
//    }

//    sh """
//     docker image push ${hubUser}/${project}:${ImageTag}
//     docker image push ${hubUser}/${project}:latest
//    """
//}

def call(String aws_account_id, String region, String ecr_repoName){

    withCredentials([
        string(credentialsId: 'AWS_Access_key', variable: 'AWS_Access_Key'), 
        string(credentialsId: 'AWS_Secret_Access_Key', variable: 'AWS_Secret_Access_Key')
    ]) {
        sh """
        aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
        docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest  
        """
    }
}


//    sh """
//     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
     
//    """
//}    
    
    
//    sh """
//     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
     
//    """



//withCredentials([
//    string(credentialsId: 'AWS_Access_key', variable: 'AWS_Access_Key'), 
//    string(credentialsId: 'AWS_Secret_Access_Key', variable: 'AWS_Secret_Access_Key')
//]) {
//    sh """
//    aws configure set aws_access_key_id "\$AWS_Access_Key"
//    aws configure set aws_secret_access_key "\$AWS_Secret_Access_Key"
//    docker login --username AWS --password-stdin 217340246210.dkr.ecr.us-east-1.amazonaws.com
//    """
//}