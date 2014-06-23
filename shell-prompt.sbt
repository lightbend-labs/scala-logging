shellPrompt in ThisBuild := (state => s"${(Project extract state).currentRef.project}> ")
