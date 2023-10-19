//def call(String project, String ImageTag, String hubUser){

//    sh """
//     docker rmi ${hubUser}/${project}:${ImageTag}
//     docker rmi ${hubUser}/${project}:latest
//    """
//}

def call(String aws_account-id, String region, String ecr_repoName){
    sh """
    
     docker rmi ${ecr_repoName}:latest ${aws_account-id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
     
    """
}