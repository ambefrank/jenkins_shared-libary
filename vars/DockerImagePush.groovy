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

def call(String aws_account-id, String region, String ecr_repoName){
    sh """
     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account-id}.dkr.ecr.${region}.amazonaws.com
     docker push ${ecr_repoName}:latest ${aws_account-id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
     
    """
}