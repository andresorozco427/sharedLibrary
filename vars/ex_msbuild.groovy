import org.somecompany.build.MsBuild
import org.somecompany.ioc.ContextRegistry

def call(String solutionPath){
    ContextRegistry.registerDEfaultContext(solutionPath)

    def msbuild = new MsBuild(solutionPath)
    msbuild.build()
}

def buildDatabase(String serverName){
    ContextRegistry.registerDEfaultContext(serverName)

    def msbuild = new MsBuild()
    msbuild.buildDatabase(serverName)
}