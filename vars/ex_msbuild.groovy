import org.somecompany.build.MsBuild
import org.somecompany.ioc.ContextRegistry

def call(String solutionPath){
    ContextRegistry.registerDEfaultContext(this)
    def msbuild = new MsBuild()
    msbuild.build(solutionPath)
}

def buildDatabase(String serverName){
    ContextRegistry.registerDEfaultContext(this)

    def msbuild = new MsBuild()
    msbuild.buildEntryFileDatabase(serverName)
}
