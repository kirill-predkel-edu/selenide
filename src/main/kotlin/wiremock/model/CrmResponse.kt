package wiremock.model

data class CrmResponse(private val id: Int?,
     val userName: String?,
     val localizedRole: String?,
     val roleId: Int?,
     val distribution: String?,
     val online: String?,
     val error: String?,
     val expired: Boolean?) {
}