package net.digitalingot.feather;

import net.minecraft.client.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.regex.*;
import net.digitalingot.feather.mixin.core.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.awt.*;

@dP(eL = dW.CHAT_OPTIONS, eM = @dV(fh = "Chat Options", fi = "https://assets.feathercdn.net/game/sidebar/chat.svg", fj = "", fk = {}, fl = @dV.a(fh = "Chat", fm = @em(fS = 1))))
public final class fs extends dQ<a>
{
    private Minecraft minecraft;
    private final Map<String, Integer> mt;
    private final Set<String> mu;
    private Pattern mv;
    private String mw;
    private String mx;
    private boolean my;
    
    public fs() {
        this.mt = new LinkedHashMap<String, Integer>(5);
        this.mu = (Set<String>)Sets.newHashSet((Object[])new String[] { "-----------------------------------------------------" });
    }
    
    @Override
    public void initialize() {
        this.minecraft = Minecraft.getMinecraft();
        aR.aR();
        this.gX();
        Q.bk.a(this::a);
        P.bk.a(s -> {
            this.mx = s.toLowerCase(Locale.ROOT);
            return s;
        });
        bJ.a(() -> ((a)this.jC).mA, () -> {
            if (this.minecraft.currentScreen == null) {
                ((a)this.jC).mB = !((a)this.jC).mB;
            }
        }, null);
    }
    
    @Override
    public void eP() {
        this.gX();
    }
    
    private void gX() {
        final String username = this.minecraft.getSession().getUsername();
        this.mv = Pattern.compile(username, 2);
        this.mw = this.F(username);
    }
    
    private String F(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(EnumChatFormatting.RESET);
        sb.append(((a)this.jC).mI.toString);
        if (((a)this.jC).mJ) {
            sb.append(EnumChatFormatting.BOLD);
        }
        sb.append(s);
        sb.append(EnumChatFormatting.RESET);
        return sb.toString();
    }
    
    private IChatComponent a(final IChatComponent chatComponent) {
        if (((a)this.jC).mH) {
            this.my = false;
            this.b(chatComponent);
            if (this.my) {
                this.mx = null;
            }
        }
        if (((a)this.jC).mE) {
            final String unformattedText = chatComponent.getUnformattedText();
            if (unformattedText.trim().isEmpty() || this.mu.contains(unformattedText)) {
                return chatComponent;
            }
            if (this.mt.size() > (((a)this.jC).mF ? 1 : 5)) {
                final Iterator<Map.Entry<String, Integer>> iterator = this.mt.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
            int size = this.mt.size();
            int intValue = -1;
            for (final Map.Entry<String, Integer> entry : this.mt.entrySet()) {
                --size;
                if (entry.getKey().equals(unformattedText)) {
                    intValue = entry.getValue();
                    break;
                }
            }
            if (intValue != -1 && this.gY()) {
                this.M(size);
                this.a(chatComponent, intValue + 1);
                this.mt.remove(unformattedText);
                this.mt.put(unformattedText, intValue + 1);
            }
            else {
                this.mt.put(unformattedText, 1);
            }
        }
        return chatComponent;
    }
    
    private boolean b(final IChatComponent chatComponent) {
        boolean b = false;
        final ChatStyle chatStyle = chatComponent.getChatStyle();
        if (chatComponent instanceof ChatComponentText) {
            final String a = this.a(((ChatComponentText)chatComponent).getChatComponentText_TextValue(), chatStyle);
            if (a != null) {
                ((l)chatComponent).setText(a);
                return true;
            }
        }
        else if (chatComponent instanceof ChatComponentTranslation) {
            final Object[] formatArgs = ((ChatComponentTranslation)chatComponent).getFormatArgs();
            for (int i = 0; i < formatArgs.length; ++i) {
                final Object o = formatArgs[i];
                if (o != chatComponent) {
                    if (o instanceof IChatComponent) {
                        b |= this.b((IChatComponent)o);
                    }
                    else if (o instanceof String) {
                        final String a2 = this.a((String)o, chatStyle);
                        if (a2 != null) {
                            formatArgs[i] = a2;
                            b = true;
                        }
                    }
                }
            }
            if (b) {
                ((m)chatComponent).setLastUpdate(-1L);
            }
        }
        for (final IChatComponent chatComponent2 : chatComponent.getSiblings()) {
            if (chatComponent2 != chatComponent) {
                b |= this.b(chatComponent2);
            }
        }
        return b;
    }
    
    private String a(final String s, final ChatStyle chatStyle) {
        if (this.my || (!((a)this.jC).mK && this.mx != null && jP.aS(s).toLowerCase(Locale.ROOT).contains(this.mx))) {
            this.my = true;
            return null;
        }
        final Matcher matcher = this.mv.matcher(s);
        if (matcher.find()) {
            final kn.a au = kn.aU(s);
            final StringBuffer sb = new StringBuffer();
            do {
                final kn.b ap = au.aP(matcher.end());
                String s2 = ap.tM();
                if (!ap.tN() && chatStyle.getColor() != null) {
                    s2 += chatStyle.getColor().toString();
                }
                matcher.appendReplacement(sb, this.mw + s2);
            } while (matcher.find());
            matcher.appendTail(sb);
            return sb.toString();
        }
        return null;
    }
    
    private void M(final int n) {
        final GuiNewChat chatGUI = this.minecraft.ingameGUI.getChatGUI();
        int n2 = 0;
        int size = 0;
        for (int i = 0; i <= n; ++i) {
            size = GuiUtilRenderComponents.splitText(((b)chatGUI).getAllMessages().get(i).getChatComponent(), MathHelper.floor_float(chatGUI.getChatWidth() / chatGUI.getChatScale()), this.minecraft.fontRendererObj, false, false).size();
            n2 += size;
        }
        ((b)chatGUI).getAllMessages().remove(n);
        ((b)chatGUI).getTrimmedMessages().subList(n2 - size, n2).clear();
    }
    
    private boolean gY() {
        return !((b)this.minecraft.ingameGUI.getChatGUI()).getAllMessages().isEmpty();
    }
    
    private void a(final IChatComponent chatComponent, final int n) {
        chatComponent.appendText(" [" + n + "]");
    }
    
    public static final class a extends ea
    {
        @em(fS = 0)
        public eW mz;
        @er(fu = "keyToggleChat", fh = "Toggle Chat", fW = "0", fm = @em(fS = 1))
        public bH mA;
        @er(fu = "chatHidden", fh = "Chat Hidden", fW = "false", fm = @em(fS = -10))
        public transient boolean mB;
        @er(fu = "unlimitedScrollback", fh = "Unlimited Scrollback", fW = "true", fm = @em(fS = 3))
        public boolean mC;
        @er(fu = "backgroundColor", fh = "Background Color", fW = "0/0/0/128", fm = @em(fS = 4))
        public Color la;
        @er(fu = "textShadow", fh = "Text Shadow", fW = "true", fm = @em(fS = 5))
        public boolean lh;
        @em(fS = 10)
        public eW mD;
        @er(fu = "stackMessages", fh = "Stack Repeated Messages", fW = "true", fm = @em(fS = 11))
        public boolean mE;
        @er(fu = "consecutiveMessagesOnly", fh = "Consecutive Messages Only", fW = "false", fZ = @en(fu = "stackMessages"), fm = @em(fS = 12))
        public boolean mF;
        @em(fS = 20)
        public eW mG;
        @er(fu = "mentionHighlight", fh = "Highlight", fW = "false", fm = @em(fS = 21))
        public boolean mH;
        @er(fu = "mentionColor", fh = "Color", fW = "green", fZ = @en(fu = "mentionHighlight"), fm = @em(fS = 22))
        @eh
        public eU mI;
        @er(fu = "mentionBold", fh = "Bold", fW = "false", fZ = @en(fu = "mentionHighlight"), fm = @em(fS = 23))
        public boolean mJ;
        @er(fu = "mentionOwnMessage", fh = "Own Messages", fW = "false", fZ = @en(fu = "mentionHighlight"), fm = @em(fS = 24))
        public boolean mK;
        
        public a() {
            this.mz = new eW("Chat Settings");
            this.mD = new eW("Stack Messages");
            this.mG = new eW("Mentions");
        }
        
        @Override
        public boolean dG() {
            return true;
        }
    }
}
