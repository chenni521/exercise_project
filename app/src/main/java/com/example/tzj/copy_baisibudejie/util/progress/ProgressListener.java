package com.example.tzj.copy_baisibudejie.util.progress;

public interface ProgressListener {

    void progress(long bytesRead, long contentLength, boolean done);

}
