def allureReportExample(path) {
        allure([
                includeProperties: true,
                jdk              : '',
                properties       : [],
                reportBuildPolicy: 'ALWAYS',
                results          : [[path: "${path}"]]
        ])
}