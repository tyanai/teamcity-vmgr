package jetbrains.buildServer.vmgr.server;

import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.util.StringUtil;
import jetbrains.buildServer.vmgr.common.VMGRRunnerConstants;

import java.util.Collection;
import java.util.Map;

/**
* Created by Tal.Yanai
* date: 07.12.14.
*/
class VMGRvAPIPropertiesProcessor extends BasePropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> properties) {
        Collection<InvalidProperty> result = super.process(properties);
        
        /*
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.VAPI_STATIC_INPUT)) &&
                VMGRRunnerConstants.STATIC_VAPI_TYPE .equals(properties.get(VMGRRunnerConstants.VAPI_TYPE))) {
            result.add(new InvalidProperty(VMGRRunnerConstants.VAPI_STATIC_INPUT, "API input must be specified."));
        }
        */
    
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.VAPI_URL))){
        	result.add(new InvalidProperty(VMGRRunnerConstants.VAPI_URL, "API call must be specified."));
        }
        return result;
    }
}
