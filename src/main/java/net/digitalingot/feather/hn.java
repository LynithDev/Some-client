package net.digitalingot.feather;

import java.awt.image.*;
import org.jetbrains.annotations.*;
import java.awt.datatransfer.*;

public class hn implements Transferable
{
    @NotNull
    private final BufferedImage yM;
    
    public hn(@NotNull final BufferedImage ym) {
        this.yM = ym;
    }
    
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { DataFlavor.imageFlavor };
    }
    
    @Override
    public boolean isDataFlavorSupported(final DataFlavor dataFlavor) {
        return DataFlavor.imageFlavor.equals(dataFlavor);
    }
    
    @Override
    public Object getTransferData(final DataFlavor dataFlavor) {
        if (DataFlavor.imageFlavor.equals(dataFlavor)) {
            return this.yM;
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }
}
