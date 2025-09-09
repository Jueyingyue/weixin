package com.liyue.weixin.httpRequest.domain.entity;

import java.util.List;

public class MessageResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Integer errcode;    // 错误码（非0表示失败）
    private String errmsg;      // 错误信息

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    // 内部类：Choice
    public static class Choice {
        private int index;
        private Message message;

        // Getters and Setters
        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        // 内部类：Message
        public static class Message {
            private String role;
            private String content;
            private String reasoning_content; // 注意：原JSON中存在该字段，但非标准Chat Completion字段

            // Getters and Setters
            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getReasoning_content() {
                return reasoning_content;
            }

            public void setReasoning_content(String reasoning_content) {
                this.reasoning_content = reasoning_content;
            }
        }
    }

    /**
     * 是否请求成功（errcode == 0）
     */
    public boolean isSuccess() {
        return errcode == null || errcode == 0;
    }
}
