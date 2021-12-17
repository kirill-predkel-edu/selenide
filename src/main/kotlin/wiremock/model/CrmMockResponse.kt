package wiremock.model

data class CrmMockResponse(private val id: Int=1,
     val userName: String = "Master Testov",
     val localizedRole: String = "Super Administrator",
     val roleId: Int = 11,
     val distribution: String? = null,
     val online: String? = null,
     val error: String? = null,
     val expired: Boolean = false) {
}