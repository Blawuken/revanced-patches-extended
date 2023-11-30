package app.revanced.patches.music.general.branding.icon

import app.revanced.patcher.data.ResourceContext
import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.util.resources.IconHelper.customIconMusic

@Patch(
    name = "Custom branding icon Revancify Red",
    description = "Changes the YouTube Music launcher icon to Revancify Red.",
    compatiblePackages = [
        CompatiblePackage(
            "com.google.android.apps.youtube.music",
            [
                "6.21.52",
                "6.27.54",
                "6.28.52"
            ]
        )
    ]
)
@Suppress("unused")
object CustomBrandingIconRevancifyRedPatch : ResourcePatch() {
    override fun execute(context: ResourceContext) {

        context.customIconMusic("revancify-red")

    }

}
