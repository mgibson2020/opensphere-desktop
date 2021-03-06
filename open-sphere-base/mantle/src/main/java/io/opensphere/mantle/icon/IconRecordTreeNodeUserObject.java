package io.opensphere.mantle.icon;

import java.util.List;

/**
 * The Interface IconRecordTreeNodeUserObject.
 */
public interface IconRecordTreeNodeUserObject
{
    /**
     * Gets the label.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Gets the name type.
     *
     * @return the name type
     */
    NameType getNameType();

    /**
     * Gets icon records for this node.
     *
     * @param recurse the recurse to all children including children folders.
     * @return the child {@link IconRecord}s.
     */
    List<IconRecord> getRecords(boolean recurse);

    /**
     * Gets the type.
     *
     * @return the type
     */
    Type getType();

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    String toString();

    /**
     * The Enum NameType.
     */
    enum NameType
    {
        /** The COLLECTION. */
        COLLECTION,

        /** The SUBCATEGORY. */
        SUBCATEGORY
    }

    /**
     * The Enum Type.
     */
    enum Type
    {
        /** The FOLDER. */
        FOLDER,

        /** The LEAF. */
        LEAF
    }
}
