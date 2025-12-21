$projects = @(
    "./apiGateway",
    "./eureka",
    "./notifications",
    "./userInterface"
)

$buildCommand = { .\gradlew jibDockerBuild }

foreach ($project in $projects) {
    if (Test-Path $project) {
        Write-Host "--- Building : $project ---" -ForegroundColor Cyan
        
        Push-Location $project
        Invoke-Command -ScriptBlock $buildCommand
        Pop-Location
    }
    else {
        Write-Warning "Project $project does not exists!"
    }
}