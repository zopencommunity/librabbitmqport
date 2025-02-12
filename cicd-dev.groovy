node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/librabbitmqport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/librabbitmqport.git'), string(name: 'PORT_DESCRIPTION', value: 'RabbitMQ C AMQP client library' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
