internal class WiremockTest : BaseWiremockTest() {
  private val localizedRole: String = "Super Administrator"
  private val userName: String = "Master Testov"
  private val roleId: Int = 11

  // @Test
//  fun wiremockTest() {
//    val crmLoginEndpoint = "/secure/rest/sign/in"
//    val wiremockServer = WiremockLocalServer()
//    wiremockServer.start()
//    wiremockServer.addStubForEndpoint(crmLoginEndpoint)
//
//    val controller = CrmLoginService()
//    val response = controller.postCrmLogin()
//
//    val responseLocalizedRole: String? = response.body()?.localizedRole
//    val responseUserName: String? = response.body()?.userName
//    val responseRoleId: Int? = response.body()?.roleId
//    println(response.toString())
//    assertEquals(localizedRole, responseLocalizedRole)
//    assertEquals(userName, responseUserName)
//    assertEquals(roleId, responseRoleId)
//    wiremockServer.stop()

}
