package org.somecompany

class StepExecutor implements IStepExecutor{

    private _steps

    StepExecutor(_steps) {
        this._steps = _steps
    }

    @Override
    int bat(String command) {
        this._steps.bat returnStatus: true, script: "${command}"
    }

    @Override
    void error(String message) {
        this._steps.error(message)
    }
}
