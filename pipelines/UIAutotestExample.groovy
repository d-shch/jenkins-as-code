@Library('lib') _

node('master') {
    stage('Precondition') {
        deleteDir()
    }
    stage('Execute tests') {
        sh(label: 'Execute autotests',
            script: 'echo "execute autotests for drowser ${BROWSER}"')
    }
    stage('Allure report') {
        lib.allureReportExample('allure_report')
    }
}
