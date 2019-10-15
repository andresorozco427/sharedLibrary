package org.somecompany.ioc

import org.somecompany.IStepExecutor
import org.somecompany.StepExecutor

class DefaultContext implements  IContext, Serializable{

    private _steps

    DefaultContext(_steps) {
        this._steps = _steps
    }

    @Override
    IStepExecutor getStepExecutor() {
        return new StepExecutor(this._steps)
    }
}
