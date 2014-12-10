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

class VMGRSessionLaunchPropertiesProcessor extends BasePropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> properties) {
        Collection<InvalidProperty> result = super.process(properties);
        
        System.out.println("In debug " + VMGRRunnerConstants.STATIC_VSIF_FILE_NAME);
        System.out.println("In debug " + VMGRRunnerConstants.VSIF_TYPE);
        System.out.println("In debug " + VMGRRunnerConstants.STATIC_VSIF_TYPE);
        System.out.println("In debug " + StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.STATIC_VSIF_FILE_NAME)));
        if (StringUtil.isEmptyOrSpaces(properties.get(VMGRRunnerConstants.STATIC_VSIF_FILE_NAME)) &&
                VMGRRunnerConstants.STATIC_VSIF_TYPE .equals(properties.get(VMGRRunnerConstants.VSIF_TYPE))) {
            result.add(new InvalidProperty(VMGRRunnerConstants.STATIC_VSIF_FILE_NAME, "Static VSIF input file must be specified."));
            System.out.println("In debug Added" );
        }
       
        return result;
    }
}
