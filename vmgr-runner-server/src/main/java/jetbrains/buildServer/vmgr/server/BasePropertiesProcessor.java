package jetbrains.buildServer.vmgr.server;

import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.util.StringUtil;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Tal Yanai
 * Date: 7/12/14
 */

public class BasePropertiesProcessor implements PropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> properties) {
    	
        Collection<InvalidProperty> result = new HashSet<InvalidProperty>();
        
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.PARAM_TARGET_URL))) {
            result.add(new InvalidProperty(VMGRRunnerConstants.PARAM_TARGET_URL, "The target must be specified."));
        }
        
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.PARAM_USERNAME)) &&
                VMGRRunnerConstants.AUTH_REQUIRED_YES.equals(properties.get(VMGRRunnerConstants.AUTH_REQUIRED))) {
            result.add(new InvalidProperty(VMGRRunnerConstants.PARAM_USERNAME, "Username must be specified."));
        }
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.PARAM_PLAIN_PASSWORD)) &&
                VMGRRunnerConstants.AUTH_REQUIRED_YES.equals(properties.get(VMGRRunnerConstants.AUTH_REQUIRED))) {
            result.add(new InvalidProperty(VMGRRunnerConstants.PARAM_PLAIN_PASSWORD, "Password must be specified."));
        }
        
        return result;
    }
}
