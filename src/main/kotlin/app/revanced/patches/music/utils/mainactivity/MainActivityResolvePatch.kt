package app.revanced.patches.music.utils.mainactivity

import app.revanced.extensions.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.util.proxy.mutableTypes.MutableMethod
import app.revanced.patches.music.utils.mainactivity.fingerprints.MainActivityFingerprint
import app.revanced.util.integrations.Constants.MUSIC_UTILS_PATH
import com.android.tools.smali.dexlib2.iface.ClassDef

object MainActivityResolvePatch : BytecodePatch(
    setOf(MainActivityFingerprint)
) {
    lateinit var mainActivityClassDef: ClassDef
    private lateinit var onCreateMethod: MutableMethod

    override fun execute(context: BytecodeContext) {
        MainActivityFingerprint.result?.let {
            mainActivityClassDef = it.classDef
            onCreateMethod = it.mutableMethod
        } ?: throw MainActivityFingerprint.exception
    }

    fun injectInit(
        methods: String,
        descriptor: String
    ) {
        onCreateMethod.apply {
            addInstruction(
                2,
                "invoke-static/range {p0 .. p0}, $MUSIC_UTILS_PATH/$methods;->$descriptor(Landroid/content/Context;)V"
            )
        }
    }
}