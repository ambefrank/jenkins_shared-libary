//def call(String project, String ImageTag, String hubUser){

//    sh """

//     trivy image ${hubUser}/${project}:latest > scan.txt
//     cat scan.txt
//    """
//}

def call(String aws_account-id, String region, String ecr_repoName){
    sh """
     trivy image ${ecr_repoName} ${aws_account-id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > scan.txt
     cat scan.txt
    """
}