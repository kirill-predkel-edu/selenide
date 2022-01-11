package config.context

import config.context.dynamic.DynamicAuthUserContext
import config.context.dynamic.DynamicContextHolder

internal fun dynamicAuthUserContext() = DynamicContextHolder.getContext() as DynamicAuthUserContext
internal fun getAuthUser(): String? = dynamicAuthUserContext().getAuthUserCookie()