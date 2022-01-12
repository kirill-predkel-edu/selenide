package config.context

import config.context.dynamic.DynamicContextHolder

internal fun dynamicContext() = DynamicContextHolder.getContext()
internal fun getAuthUser(): String = dynamicContext().getSessionContext().getAuthUserCookie()