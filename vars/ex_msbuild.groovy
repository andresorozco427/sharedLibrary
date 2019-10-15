import org.somecompany.build.MsBuild
import org.somecompany.ioc.ContextRegistry

def call(String solutionPath){
    ContextRegistry.registerDEfaultContext(this)

    def msbuild = new MsBuild(solutionPath, null)
    msbuild.build()
}

def buildDatabase(String serverName){
    ContextRegistry.registerDEfaultContext(this)

    def msbuild = new MsBuild(null,serverName)
    msbuild.buildDatabase()
}