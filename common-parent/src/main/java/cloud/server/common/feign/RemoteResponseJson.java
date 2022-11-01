package cloud.server.common.feign;

import java.io.Serializable;

/**
 * @author: Jian Chen
 * @create: 2022-10
 **/
public class RemoteResponseJson<T> implements Serializable {
    private static final long serialVersionUID = -6278244595331440130L;

    private T data;

    public RemoteResponseJson() {
    }

    public RemoteResponseJson(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
