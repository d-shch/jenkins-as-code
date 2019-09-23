@Library('lib') _

node('master') {
    stage('Precondition') {
        deleteDir()
    }
    stage('Execute tests') {
        sh(label: 'Clone repo',
            script: """
                echo "Clone repo from branch ${BRANCH}"
            """)
        sh(label: 'Execute autotests',
            script: """
                echo "execute autotests for browser ${BROWSER}"
            """)
    }
    stage('Allure report') {
        lib.allureReportExample('allure_report')
    }
}
