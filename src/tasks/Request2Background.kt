package tasks

import contributors.GitHubService
import contributors.RequestData
import contributors.User
import kotlin.concurrent.thread

// solve 3: Using callbacks
fun loadContributorsBackground(service: GitHubService, req: RequestData, updateResults: (List<User>) -> Unit) {
    thread {
        val users = loadContributorsBlocking(service, req)
            .aggregate()

        updateResults(users)
    }
}