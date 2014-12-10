package jetbrains.buildServer.vmgr.agent.launch;

import java.io.File;
import java.util.List;

import jetbrains.buildServer.RunBuildException;
import jetbrains.buildServer.agent.BuildRunnerContext;
import jetbrains.buildServer.agent.impl.artifacts.ArtifactsCollection;
import jetbrains.buildServer.vmgr.agent.SyncBuildProcessAdapter;
import jetbrains.buildServer.vmgr.agent.Utils;
import jetbrains.buildServer.vmgr.common.PluginParams;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

public class SessionLaunchProcessAdapter extends SyncBuildProcessAdapter {

	private PluginParams myPluginParams;
	private String checkoutDir;
	private String buildId;

	public SessionLaunchProcessAdapter(
			@NotNull final BuildRunnerContext context,
			@NotNull final List<ArtifactsCollection> artifactsCollections,
			@NotNull final PluginParams pluginParams) {
		super(context.getBuild().getBuildLogger());

		myPluginParams = pluginParams;
		checkoutDir = context.getBuild().getCheckoutDirectory()
				.getAbsolutePath();
		buildId = context.getBuild().getBuildId() + "";

	}

	@Override
	public void runProcess() throws RunBuildException {

		try {

			myLogger.message("Listing the runner parameters:");
			// myLogger.message("PARAM_TARGET_URL: " + vAPIURL);
			myLogger.message(myPluginParams.toString());
			myLogger.message("Build working directory: " + checkoutDir);
			myLogger.message("Build id: " + buildId);
			myLogger.message("Dynamic input and out will be placed into: "
					+ checkoutDir + File.separator + buildId);

			Utils utils = new Utils();
			// Get the list of VSIF file to launch
			String[] vsifFileNames = null;

			if (VMGRRunnerConstants.STATIC_VSIF_TYPE
					.equals(myPluginParams.VSIF_TYPE)) {
				myLogger.message("The VSIF file chosen is static. VSIF file static location is: '"
						+ myPluginParams.STATIC_VSIF_FILE_NAME + "'");
				vsifFileNames = new String[1];
				vsifFileNames[0] = myPluginParams.STATIC_VSIF_FILE_NAME;
			} else {
				if (myPluginParams.DYNAMIC_VSIF_FILE_NAME == null
						|| myPluginParams.DYNAMIC_VSIF_FILE_NAME.trim().equals(
								"")) {
					myLogger.message("The VSIF file chosen is dynamic. VSIF directory dynamic workspace directory: '"
							+ checkoutDir + File.separator + buildId + "'");
				} else {
					myLogger.message("The VSIF file chosen is dynamic. VSIF file name is: '"
							+ myPluginParams.DYNAMIC_VSIF_FILE_NAME.trim()
							+ "'");
				}
				vsifFileNames = utils.loadVSIFFileNames(buildId, checkoutDir,
						myPluginParams.DYNAMIC_VSIF_FILE_NAME, myLogger, false);

			}

			// Now call the actual launch
			// ----------------------------------------------------------------------------------------------------------------
			boolean dynamicUser = false;
			if ("true".equals(myPluginParams.DYNAMIC_USER)) {
				dynamicUser = true;
			}

			boolean authRequired = false;
			if (myPluginParams.AUTH_REQUIRED
					.equals(VMGRRunnerConstants.AUTH_REQUIRED_YES)) {
				authRequired = true;
			}

			String output = utils.executeVSIFLaunch(vsifFileNames,
					myPluginParams.PARAM_TARGET_URL, authRequired,
					myPluginParams.PARAM_USERNAME,
					myPluginParams.PARAM_PLAIN_PASSWORD, myLogger, dynamicUser,
					buildId, checkoutDir);

			if (!"success".equals(output)) {
				myLogger.message(output);
				throw new Exception(output);

			}
			// ----------------------------------------------------------------------------------------------------------------

			myLogger.message("Finished success");
		} catch (Exception e) {
			myLogger.buildFailureDescription(e.getMessage());
        	myLogger.logTestFailed("Failed to launch vsifs for build " + buildId, e);
			myLogger.error("Failed to launch vsifs for build " + buildId);
			throw new RunBuildException(e);
		} finally {

		}
	}

}
