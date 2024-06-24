package com.github.megatronking.stringfog.plugin

import com.github.megatronking.stringfog.IKeyGenerator
import com.github.megatronking.stringfog.plugin.kg.RandomKeyGenerator

abstract class StringFogExtension {

    companion object {
        val base64 = StringFogMode.base64
        val bytes = StringFogMode.bytes
    }

    /**
     * The package name of the application or the library.
     */
    var packageName: String? = null

    /**
     * The algorithm implementation for String encryption and decryption.
     * It is required.
     */
    var implementation: String? = null

    /**
     * A generator to generate a security key for the encryption and decryption.
     *
     * StringFog use a 8 length random key generator default.
     */
    var kg : IKeyGenerator  = RandomKeyGenerator()

    /**
     * How the encrypted string presents in java class, default is base64.
     */
    var mode: StringFogMode = base64

    /**
     * Enable or disable the StringFog plugin. Default is enabled.
     */
    var enable: Boolean = true

    /**
     * Enable or disable the StringFog debug message print. Default is disabled.
     */
    var debug: Boolean = false

    /**
     * The java packages will be applied. Default is effect on all packages.
     */
    var fogPackages : Array<String> = emptyArray()

    /**
     * Whether to encrypt all strings in a class, including dependency packages.
     *
     * Setting to true does not take effect for library projects, as instrumenting library dependencies will have no effect on library consumers.
     */
    var fogAll: Boolean = false

    /**
     * 需要加密的类的匹配规则
     */
    var fogRegex : String = ".*"


    /**
     * buildConfig 是否加密，默认否
     */
    var buildConfig: Boolean = false
}