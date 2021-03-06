package http.services.crm.retrofit.model

data class CrmResponseStub(
  val id: Int?,
  val userName: String?,
  val localizedRole: String?,
  val roleId: Int?,
  val distribution: String?,
  val online: String?,
  val error: String?,
  val expired: Boolean?
) : Stub