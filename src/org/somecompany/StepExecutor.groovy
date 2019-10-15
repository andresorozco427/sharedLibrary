package org.somecompany

class StepExecutor implements IStepExecutor{

    private _steps

    StepExecutor(_steps) {
        this._steps = _steps
    }

    @Override
    int bat(String command) {
        println "inicio bat en StepExecutor"
        this._steps.bat returnStatus: true, script: "${command}"
        println "final bat en StepExecutor"
    }

    @Override
    void error(String message) {
        this._steps.error(message)
    }
}
