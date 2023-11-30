package app.revanced.patches.youtube.player.speedoverlay.fingerprints

import app.revanced.patcher.fingerprint.MethodFingerprint
import app.revanced.util.bytecode.isWide32LiteralExists
import com.android.tools.smali.dexlib2.Opcode

/**
 * This value disables 'Playing at 2x speed' while holding down.
 */
object SpeedOverlayFingerprint : MethodFingerprint(
    returnType = "Z",
    parameters = emptyList(),
    opcodes = listOf(Opcode.MOVE_RESULT),
    customFingerprint = { methodDef, _ -> methodDef.isWide32LiteralExists(45411330) }
)