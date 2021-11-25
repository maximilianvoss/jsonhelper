open module rocks.voss.jsonhelper {
    requires transitive org.apache.commons.io;
    requires transitive com.fasterxml.jackson.core;
    requires transitive com.fasterxml.jackson.annotation;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive org.apache.logging.log4j;

    exports rocks.voss.jsonhelper;
}
