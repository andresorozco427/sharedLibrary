package org.somecompany

class StepExecutor implements IStepExecutor{

    private _steps

    StepExecutor(_steps) {
        this._steps = _steps
    }

    @Override
    int sh(String command) {
        this._steps.sh returnStatus: true, script: "${command}"
    }

    @Override
    void error(String message) {
        this._steps.error(message)
    }
}
