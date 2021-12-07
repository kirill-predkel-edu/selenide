package http.request

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class OkHttpBodyRequest(private val bodyContent: String, private val bodyType: String) : CustomHttpBodyRequest {
  fun makeRequestBody(): RequestBody {
    return bodyContent.toRequestBody(bodyType.toMediaType())
  }
}