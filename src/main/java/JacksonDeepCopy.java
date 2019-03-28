import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeepCopy {

    public static void main(String[] args) {
        JacksonDeepCopy example = new JacksonDeepCopy();
        example.demo();
    }

    private void demo() {
        ObjectMapper mapper = new ObjectMapper();

        SourceBean source = new SourceBean(
                "source",
                new SourceNestedBean("nested"),
                new SourceNestedBean("nested2"));

        System.out.println("BEFORE");
        System.out.println(source);
        System.out.println();

        TargetBean target = mapper.convertValue(source, TargetBean.class);

        System.out.println("AFTER CONVERT");
        System.out.println(source);
        System.out.println(target);
        System.out.println();

        target.getNestedBean().setNestedBeanField("newValue");
        target.getNestedBean2().setNestedBeanField("newValue2");

        System.out.println("AFTER set");
        System.out.println(source);
        System.out.println(target);
        System.out.println();
    }

    public static class SourceBean {

        private String beanField;

        private SourceNestedBean nestedBean;

        private SourceNestedBean nestedBean2;

        public SourceBean() {
        }

        public SourceBean(String beanField, SourceNestedBean nestedBean, SourceNestedBean nestedBean2) {
            this.beanField = beanField;
            this.nestedBean = nestedBean;
            this.nestedBean2 = nestedBean2;
        }

        @Override
        public String toString() {
            return "SourceBean{" +
                    "beanField='" + beanField + '\'' +
                    ", nestedBean=" + nestedBean +
                    ", nestedBean2=" + nestedBean2 +
                    '}';
        }

        public String getBeanField() {
            return beanField;
        }

        public void setBeanField(String beanField) {
            this.beanField = beanField;
        }

        public SourceNestedBean getNestedBean() {
            return nestedBean;
        }

        public void setNestedBean(SourceNestedBean nestedBean) {
            this.nestedBean = nestedBean;
        }

        public SourceNestedBean getNestedBean2() {
            return nestedBean2;
        }

        public void setNestedBean2(SourceNestedBean nestedBean2) {
            this.nestedBean2 = nestedBean2;
        }
    }

    public static class SourceNestedBean {

        private String nestedBeanField;

        public SourceNestedBean() {
        }

        @Override
        public String toString() {
            return "SourceNestedBean{" +
                    "nestedBeanField='" + nestedBeanField + '\'' +
                    '}';
        }

        public SourceNestedBean(String nestedBeanField) {
            this.nestedBeanField = nestedBeanField;
        }

        public String getNestedBeanField() {
            return nestedBeanField;
        }

        public void setNestedBeanField(String nestedBeanField) {
            this.nestedBeanField = nestedBeanField;
        }
    }

    public static class TargetBean {

        private String beanField;

        private TargetNestedBean nestedBean;

        private SourceNestedBean nestedBean2;

        public TargetBean() {
        }

        public TargetBean(String beanField, TargetNestedBean nestedBean, SourceNestedBean nestedBean2) {
            this.beanField = beanField;
            this.nestedBean = nestedBean;
            this.nestedBean2 = nestedBean2;
        }

        @Override
        public String toString() {
            return "TargetBean{" +
                    "beanField='" + beanField + '\'' +
                    ", nestedBean=" + nestedBean +
                    ", nestedBean2=" + nestedBean2 +
                    '}';
        }

        public String getBeanField() {
            return beanField;
        }

        public void setBeanField(String beanField) {
            this.beanField = beanField;
        }

        public TargetNestedBean getNestedBean() {
            return nestedBean;
        }

        public void setNestedBean(TargetNestedBean nestedBean) {
            this.nestedBean = nestedBean;
        }

        public SourceNestedBean getNestedBean2() {
            return nestedBean2;
        }

        public void setNestedBean2(SourceNestedBean nestedBean2) {
            this.nestedBean2 = nestedBean2;
        }
    }

    public static class TargetNestedBean {

        private String nestedBeanField;

        public TargetNestedBean() {
        }

        public TargetNestedBean(String nestedBeanField) {
            this.nestedBeanField = nestedBeanField;
        }

        @Override
        public String toString() {
            return "TargetNestedBean{" +
                    "nestedBeanField='" + nestedBeanField + '\'' +
                    '}';
        }

        public String getNestedBeanField() {
            return nestedBeanField;
        }

        public void setNestedBeanField(String nestedBeanField) {
            this.nestedBeanField = nestedBeanField;
        }
    }
}
