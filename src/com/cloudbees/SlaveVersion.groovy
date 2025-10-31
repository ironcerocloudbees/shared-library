package com.cloudbees

import java.io.IOException
import jenkins.security.MasterToSlaveCallable
import hudson.Launcher

// Note: This class needs to implement Serializable, but MasterToSlaveCallable does that.
// It also needs the imports listed above.

class SlaveVersion extends MasterToSlaveCallable<String, IOException> {

    private static final long serialVersionUID = 1L;
    
    @Override
    public String call() throws IOException {
        try {
            // Launcher is on the agent's classpath
            return Launcher.VERSION;
        } catch (Throwable ex) {
            // Older slave.jar won't have VERSION constant
            return "< 1.335";
        }
    }
}