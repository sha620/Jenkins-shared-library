def call(String credid, String imagename ){
  steps{
               withCredentials([usernamePassword(
               credentialsId: "${credid}",
               usernameVariable: "user",
               passwordVariable: "pass"
               )]){
                   sh "docker login -u ${env.user} -p ${env.pass}"
                   sh "docker image tag ${imagename} ${env.user}/${imagename}"
                   sh "docker push ${env.user}/${imagename}"
               }
            }
}
