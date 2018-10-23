// https://searchcode.com/api/result/97923585/

package org.eclipse.papyrus.alf.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAlfLexer extends Lexer {
    public static final int RULE_ID=8;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_INTEGER_VALUE=6;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__19=19;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__90=90;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_BOOLEAN_VALUE=5;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=4;
    public static final int RULE_STRING=7;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int RULE_INT=10;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators

    public InternalAlfLexer() {;} 
    public InternalAlfLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAlfLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:11:7: ( '*' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:11:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:12:7: ( '@' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:12:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13:7: ( '(' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:14:7: ( ')' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:15:7: ( ',' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:16:7: ( '=>' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:16:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:17:7: ( 'namespace' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:17:9: 'namespace'
            {
            match("namespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:18:7: ( ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:18:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:19:7: ( 'import' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:19:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:20:7: ( '::' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:20:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:21:7: ( 'as' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:21:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:22:7: ( 'public' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:22:9: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:23:7: ( 'private' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:23:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:24:7: ( 'protected' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:24:9: 'protected'
            {
            match("protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:25:7: ( 'package' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:25:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:26:7: ( '{' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:27:7: ( '}' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:27:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:28:7: ( '<' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:28:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:29:7: ( '>' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:29:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:30:7: ( 'specializes' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:30:9: 'specializes'
            {
            match("specializes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:31:7: ( 'abstract' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:31:9: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:32:7: ( 'class' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:32:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:33:7: ( 'active' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:33:9: 'active'
            {
            match("active"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:34:7: ( 'do' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:34:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:35:7: ( 'datatype' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:35:9: 'datatype'
            {
            match("datatype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:36:7: ( 'assoc' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:36:9: 'assoc'
            {
            match("assoc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:37:7: ( 'enum' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:37:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:38:7: ( 'signal' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:38:9: 'signal'
            {
            match("signal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:39:7: ( 'activity' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:39:9: 'activity'
            {
            match("activity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:40:7: ( ':' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:40:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:41:7: ( '=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:41:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:42:7: ( 'compose' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:42:9: 'compose'
            {
            match("compose"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:43:7: ( 'any' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:43:9: 'any'
            {
            match("any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:44:7: ( '[' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:44:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:45:7: ( ']' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:45:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:46:7: ( 'ordered' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:46:9: 'ordered'
            {
            match("ordered"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:47:7: ( 'nonunique' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:47:9: 'nonunique'
            {
            match("nonunique"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:48:7: ( 'sequence' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:48:9: 'sequence'
            {
            match("sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:49:7: ( '..' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:49:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:50:7: ( 'redefines' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:50:9: 'redefines'
            {
            match("redefines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:51:7: ( 'receive' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:51:9: 'receive'
            {
            match("receive"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:52:7: ( '.' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:52:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:53:7: ( 'this' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:53:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:54:7: ( 'super' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:54:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:55:7: ( 'new' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:55:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:56:7: ( 'allInstances' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:56:9: 'allInstances'
            {
            match("allInstances"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:57:7: ( 'null' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:57:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:58:7: ( '->' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:58:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:59:7: ( 'reduce' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:59:9: 'reduce'
            {
            match("reduce"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:60:7: ( '!' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:60:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:61:7: ( '~' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:61:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:62:7: ( '$' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:62:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:63:7: ( '&' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:63:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:64:7: ( '^' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:64:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:65:7: ( '|' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:65:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:66:7: ( '&&' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:66:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:67:7: ( '||' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:67:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:68:7: ( '?' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:68:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:69:7: ( '//@' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:69:9: '//@'
            {
            match("//@"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:70:7: ( '\\n' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:70:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:71:7: ( '/*@' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:71:9: '/*@'
            {
            match("/*@"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:72:7: ( 'let' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:72:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:73:7: ( 'if' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:73:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:74:7: ( 'else' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:74:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:75:7: ( 'or' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:75:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:76:7: ( 'switch' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:76:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:77:7: ( 'case' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:77:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:78:7: ( 'default' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:78:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:79:7: ( 'while' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:79:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:80:7: ( 'for' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:80:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:7: ( 'in' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:82:7: ( 'break' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:82:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:83:7: ( 'return' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:83:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:84:7: ( 'accept' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:84:9: 'accept'
            {
            match("accept"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:85:7: ( 'classify' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:85:9: 'classify'
            {
            match("classify"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:86:7: ( 'from' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:86:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:87:7: ( 'to' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:87:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:88:7: ( 'out' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:88:9: 'out'
            {
            match("out"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:89:7: ( 'inout' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:89:9: 'inout'
            {
            match("inout"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:90:7: ( 'createLink' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:90:9: 'createLink'
            {
            match("createLink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:91:7: ( 'destroyLink' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:91:9: 'destroyLink'
            {
            match("destroyLink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:92:7: ( 'clearAssoc' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:92:9: 'clearAssoc'
            {
            match("clearAssoc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:93:7: ( '++' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:93:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:94:7: ( '--' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:94:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:95:7: ( '+' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:95:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:96:7: ( '-' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:96:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:97:7: ( '/' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:97:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:98:8: ( '%' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:98:10: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:99:8: ( '<<' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:99:10: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:100:8: ( '>>' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:100:10: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:101:8: ( '>>>' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:101:10: '>>>'
            {
            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:102:8: ( '<=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:102:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:103:8: ( '>=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:103:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:104:8: ( 'instanceof' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:104:10: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:105:8: ( 'hastype' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:105:10: 'hastype'
            {
            match("hastype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:106:8: ( '==' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:106:10: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:107:8: ( '!=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:107:10: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:108:8: ( '+=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:108:10: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:109:8: ( '-=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:109:10: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:110:8: ( '*=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:110:10: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:111:8: ( '/=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:111:10: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:112:8: ( '%=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:112:10: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:113:8: ( '&=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:113:10: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:114:8: ( '|=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:114:10: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:115:8: ( '^=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:115:10: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:116:8: ( '<<=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:116:10: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:117:8: ( '>>=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:117:10: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:118:8: ( '>>>=' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:118:10: '>>>='
            {
            match(">>>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "RULE_BOOLEAN_VALUE"
    public final void mRULE_BOOLEAN_VALUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13946:20: ( ( 'true' | 'false' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13946:22: ( 'true' | 'false' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13946:22: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13946:23: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13946:30: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_VALUE"

    // $ANTLR start "RULE_INTEGER_VALUE"
    public final void mRULE_INTEGER_VALUE() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'B':
                case 'b':
                    {
                    alt14=2;
                    }
                    break;
                case 'X':
                case 'x':
                    {
                    alt14=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '_':
                    {
                    alt14=4;
                    }
                    break;
                default:
                    alt14=1;}

            }
            else if ( ((LA14_0>='1' && LA14_0<='9')) ) {
                alt14=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='0') ) {
                        alt4=1;
                    }
                    else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:24: '0'
                            {
                            match('0'); 

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                            {
                            matchRange('1','9'); 
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:37: ( ( '_' )? '0' .. '9' )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( ((LA3_0>='0' && LA3_0<='9')||LA3_0=='_') ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:38: ( '_' )? '0' .. '9'
                            	    {
                            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:38: ( '_' )?
                            	    int alt2=2;
                            	    int LA2_0 = input.LA(1);

                            	    if ( (LA2_0=='_') ) {
                            	        alt2=1;
                            	    }
                            	    switch (alt2) {
                            	        case 1 :
                            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:38: '_'
                            	            {
                            	            match('_'); 

                            	            }
                            	            break;

                            	    }

                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:55: ( '0b' | '0B' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='0') ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1=='b') ) {
                            alt5=1;
                        }
                        else if ( (LA5_1=='B') ) {
                            alt5=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:56: '0b'
                            {
                            match("0b"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:61: '0B'
                            {
                            match("0B"); 


                            }
                            break;

                    }

                    matchRange('0','1'); 
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:76: ( ( '_' )? '0' .. '1' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='1')||LA7_0=='_') ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:77: ( '_' )? '0' .. '1'
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:77: ( '_' )?
                    	    int alt6=2;
                    	    int LA6_0 = input.LA(1);

                    	    if ( (LA6_0=='_') ) {
                    	        alt6=1;
                    	    }
                    	    switch (alt6) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:77: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:93: ( '0x' | '0X' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='0') ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1=='x') ) {
                            alt8=1;
                        }
                        else if ( (LA8_1=='X') ) {
                            alt8=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:94: '0x'
                            {
                            match("0x"); 


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:99: '0X'
                            {
                            match("0X"); 


                            }
                            break;

                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='F')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='f')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:135: ( '_' )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0=='_') ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:135: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
                    {
                    match('0'); 
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:175: ( '_' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='_') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:175: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    matchRange('0','7'); 
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:189: ( ( '_' )? '0' .. '7' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='7')||LA13_0=='_') ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:190: ( '_' )? '0' .. '7'
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:190: ( '_' )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0=='_') ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13948:190: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER_VALUE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:9: ( ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* | '\\'' ( options {greedy=false; } : . )* '\\'' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='a' && LA17_0<='z')) ) {
                alt17=1;
            }
            else if ( (LA17_0=='\'') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    {
                    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:36: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:
                    	    {
                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:70: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:75: ( options {greedy=false; } : . )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='\'') ) {
                            alt16=2;
                        }
                        else if ( ((LA16_0>='\u0000' && LA16_0<='&')||(LA16_0>='(' && LA16_0<='\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13950:103: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13952:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13952:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13952:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\\') ) {
                    alt18=1;
                }
                else if ( ((LA18_0>='\u0000' && LA18_0<='!')||(LA18_0>='#' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13952:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13952:61: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13954:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13954:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13954:24: ( options {greedy=false; } : . )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='*') ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1=='/') ) {
                        alt19=2;
                    }
                    else if ( ((LA19_1>='\u0000' && LA19_1<='.')||(LA19_1>='0' && LA19_1<='\uFFFF')) ) {
                        alt19=1;
                    }


                }
                else if ( ((LA19_0>='\u0000' && LA19_0<=')')||(LA19_0>='+' && LA19_0<='\uFFFF')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13954:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\u0000' && LA20_0<='\t')||(LA20_0>='\u000B' && LA20_0<='\f')||(LA20_0>='\u000E' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:40: ( ( '\\r' )? '\\n' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='\n'||LA22_0=='\r') ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:41: ( '\\r' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0=='\r') ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13956:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13958:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13958:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13958:12: ( '0' .. '9' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='0' && LA23_0<='9')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13958:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13960:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13960:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13960:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13962:16: ( . )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:13962:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | RULE_BOOLEAN_VALUE | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER )
        int alt25=117;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:448: T__86
                {
                mT__86(); 

                }
                break;
            case 75 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:454: T__87
                {
                mT__87(); 

                }
                break;
            case 76 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:460: T__88
                {
                mT__88(); 

                }
                break;
            case 77 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:466: T__89
                {
                mT__89(); 

                }
                break;
            case 78 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:472: T__90
                {
                mT__90(); 

                }
                break;
            case 79 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:478: T__91
                {
                mT__91(); 

                }
                break;
            case 80 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:484: T__92
                {
                mT__92(); 

                }
                break;
            case 81 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:490: T__93
                {
                mT__93(); 

                }
                break;
            case 82 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:496: T__94
                {
                mT__94(); 

                }
                break;
            case 83 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:502: T__95
                {
                mT__95(); 

                }
                break;
            case 84 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:508: T__96
                {
                mT__96(); 

                }
                break;
            case 85 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:514: T__97
                {
                mT__97(); 

                }
                break;
            case 86 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:520: T__98
                {
                mT__98(); 

                }
                break;
            case 87 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:526: T__99
                {
                mT__99(); 

                }
                break;
            case 88 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:532: T__100
                {
                mT__100(); 

                }
                break;
            case 89 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:539: T__101
                {
                mT__101(); 

                }
                break;
            case 90 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:546: T__102
                {
                mT__102(); 

                }
                break;
            case 91 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:553: T__103
                {
                mT__103(); 

                }
                break;
            case 92 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:560: T__104
                {
                mT__104(); 

                }
                break;
            case 93 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:567: T__105
                {
                mT__105(); 

                }
                break;
            case 94 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:574: T__106
                {
                mT__106(); 

                }
                break;
            case 95 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:581: T__107
                {
                mT__107(); 

                }
                break;
            case 96 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:588: T__108
                {
                mT__108(); 

                }
                break;
            case 97 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:595: T__109
                {
                mT__109(); 

                }
                break;
            case 98 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:602: T__110
                {
                mT__110(); 

                }
                break;
            case 99 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:609: T__111
                {
                mT__111(); 

                }
                break;
            case 100 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:616: T__112
                {
                mT__112(); 

                }
                break;
            case 101 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:623: T__113
                {
                mT__113(); 

                }
                break;
            case 102 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:630: T__114
                {
                mT__114(); 

                }
                break;
            case 103 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:637: T__115
                {
                mT__115(); 

                }
                break;
            case 104 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:644: T__116
                {
                mT__116(); 

                }
                break;
            case 105 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:651: T__117
                {
                mT__117(); 

                }
                break;
            case 106 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:658: T__118
                {
                mT__118(); 

                }
                break;
            case 107 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:665: T__119
                {
                mT__119(); 

                }
                break;
            case 108 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:672: T__120
                {
                mT__120(); 

                }
                break;
            case 109 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:679: RULE_BOOLEAN_VALUE
                {
                mRULE_BOOLEAN_VALUE(); 

                }
                break;
            case 110 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:698: RULE_INTEGER_VALUE
                {
                mRULE_INTEGER_VALUE(); 

                }
                break;
            case 111 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:717: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 112 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:725: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 113 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:737: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 114 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:753: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 115 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:769: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 116 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:778: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 117 :
                // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1:786: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\1\64\4\uffff\1\73\1\100\1\uffff\1\100\1\106\2\100\2\uffff"+
        "\1\123\1\126\4\100\2\uffff\1\100\1\152\2\100\1\162\1\164\2\uffff"+
        "\1\171\1\173\1\176\1\uffff\1\u0083\1\u0084\4\100\1\u008e\1\u0090"+
        "\1\100\2\u0092\1\uffff\2\62\13\uffff\4\100\2\uffff\1\100\1\u009c"+
        "\1\u009f\2\uffff\1\u00a1\7\100\2\uffff\1\u00ac\2\uffff\1\u00af\2"+
        "\uffff\11\100\1\u00ba\4\100\2\uffff\1\u00c1\1\100\2\uffff\2\100"+
        "\1\u00c7\1\100\21\uffff\1\u00ca\5\uffff\6\100\5\uffff\1\100\1\uffff"+
        "\1\u0092\1\uffff\1\u0092\1\uffff\2\100\1\u00d7\2\100\1\uffff\2\100"+
        "\1\uffff\1\100\1\uffff\3\100\1\u00e0\5\100\2\uffff\1\u00e7\2\uffff"+
        "\12\100\1\uffff\6\100\1\uffff\1\u00f8\4\100\1\uffff\1\100\1\u00ff"+
        "\1\uffff\1\u0100\1\uffff\1\u0101\1\100\1\u0103\4\100\1\u0092\2\100"+
        "\1\uffff\1\u010a\7\100\1\uffff\5\100\2\uffff\10\100\1\u011f\4\100"+
        "\1\u0124\1\u0125\1\100\1\uffff\4\100\1\u012b\1\u012c\3\uffff\1\100"+
        "\1\uffff\1\u012e\5\100\1\uffff\1\100\1\u0135\1\100\1\u0137\13\100"+
        "\1\u0144\1\100\1\u0147\2\100\1\uffff\4\100\2\uffff\5\100\2\uffff"+
        "\1\u0153\1\uffff\1\u012c\1\u0154\3\100\1\u0158\1\uffff\1\100\1\uffff"+
        "\1\100\1\u015b\1\100\1\u015d\1\100\1\u015f\4\100\1\u0164\1\100\1"+
        "\uffff\1\u0166\1\100\1\uffff\10\100\1\u0170\1\100\1\u0172\2\uffff"+
        "\3\100\1\uffff\2\100\1\uffff\1\100\1\uffff\1\100\1\uffff\1\u017a"+
        "\1\100\1\u017c\1\100\1\uffff\1\100\1\uffff\2\100\1\u0181\2\100\1"+
        "\u0184\1\100\1\u0186\1\100\1\uffff\1\u0188\1\uffff\1\u0189\3\100"+
        "\1\u018d\1\u018e\1\100\1\uffff\1\100\1\uffff\1\100\1\u0192\1\u0193"+
        "\1\100\1\uffff\1\100\1\u0196\1\uffff\1\100\1\uffff\1\100\2\uffff"+
        "\1\u0199\1\u019a\1\100\2\uffff\1\100\1\u019d\1\100\2\uffff\2\100"+
        "\1\uffff\1\100\1\u01a2\2\uffff\1\u01a3\1\100\1\uffff\1\100\1\u01a6"+
        "\1\u01a7\1\100\2\uffff\1\100\1\u01aa\2\uffff\1\u01ab\1\u01ac\3\uffff";
    static final String DFA25_eofS =
        "\u01ad\uffff";
    static final String DFA25_minS =
        "\1\0\1\75\4\uffff\1\75\1\141\1\uffff\1\146\1\72\1\142\1\141\2\uffff"+
        "\1\74\1\75\1\145\2\141\1\154\2\uffff\1\162\1\56\1\145\1\150\1\55"+
        "\1\75\2\uffff\1\46\2\75\1\uffff\1\52\1\11\1\145\1\150\1\141\1\162"+
        "\1\53\1\75\1\141\2\60\1\uffff\2\0\13\uffff\1\155\1\156\1\167\1\154"+
        "\2\uffff\1\160\2\60\2\uffff\1\60\1\163\1\143\1\171\1\154\1\142\1"+
        "\151\1\143\2\uffff\1\75\2\uffff\1\75\2\uffff\1\145\1\147\1\161\1"+
        "\160\1\151\1\141\1\155\1\163\1\145\1\60\1\164\1\146\1\165\1\163"+
        "\2\uffff\1\60\1\164\2\uffff\1\143\1\151\1\60\1\165\21\uffff\1\100"+
        "\1\0\4\uffff\1\164\1\151\1\162\1\157\1\154\1\145\5\uffff\1\163\1"+
        "\uffff\1\60\1\uffff\1\60\1\uffff\1\145\1\165\1\60\1\154\1\157\1"+
        "\uffff\1\165\1\164\1\uffff\1\157\1\uffff\1\164\1\151\1\145\1\60"+
        "\1\111\1\154\1\166\1\164\1\153\2\uffff\1\75\2\uffff\1\143\1\156"+
        "\1\165\1\145\1\164\1\163\1\141\1\160\1\145\1\141\1\uffff\2\141\1"+
        "\164\1\155\2\145\1\uffff\1\60\2\145\1\165\1\163\1\uffff\1\145\1"+
        "\0\1\uffff\1\0\1\uffff\1\60\1\154\1\60\1\155\1\163\1\141\1\164\1"+
        "\60\1\163\1\156\1\uffff\1\60\1\162\1\164\1\141\1\143\1\162\1\166"+
        "\1\160\1\uffff\1\156\1\151\1\141\1\145\1\141\2\uffff\1\151\1\141"+
        "\1\145\1\162\1\143\1\163\1\162\1\157\1\60\2\164\1\165\1\162\2\60"+
        "\1\162\1\uffff\1\146\1\143\1\151\1\162\2\60\3\uffff\1\145\1\uffff"+
        "\1\60\1\145\1\153\1\171\1\160\1\151\1\uffff\1\164\1\60\1\156\1\60"+
        "\1\141\1\145\1\164\1\163\1\143\1\164\1\143\1\147\1\141\1\154\1\156"+
        "\1\60\1\150\1\60\1\101\1\163\1\uffff\1\145\1\171\1\154\1\157\2\uffff"+
        "\1\145\1\151\1\145\1\166\1\156\2\uffff\1\60\1\uffff\2\60\1\160\1"+
        "\141\1\161\1\60\1\uffff\1\143\1\uffff\1\143\1\60\1\164\1\60\1\164"+
        "\1\60\1\145\1\164\1\145\1\154\1\60\1\143\1\uffff\1\60\1\146\1\uffff"+
        "\1\163\1\145\1\114\1\160\1\164\1\171\1\144\1\156\1\60\1\145\1\60"+
        "\2\uffff\1\145\1\143\1\165\1\uffff\1\145\1\164\1\uffff\1\171\1\uffff"+
        "\1\141\1\uffff\1\60\1\145\1\60\1\151\1\uffff\1\145\1\uffff\1\171"+
        "\1\163\1\60\1\151\1\145\1\60\1\114\1\60\1\145\1\uffff\1\60\1\uffff"+
        "\1\60\2\145\1\157\2\60\1\156\1\uffff\1\144\1\uffff\1\172\2\60\1"+
        "\157\1\uffff\1\156\1\60\1\uffff\1\151\1\uffff\1\163\2\uffff\2\60"+
        "\1\146\2\uffff\1\143\1\60\1\145\2\uffff\1\143\1\153\1\uffff\1\156"+
        "\1\60\2\uffff\1\60\1\145\1\uffff\1\163\2\60\1\153\2\uffff\1\163"+
        "\1\60\2\uffff\2\60\3\uffff";
    static final String DFA25_maxS =
        "\1\uffff\1\75\4\uffff\1\76\1\165\1\uffff\1\156\1\72\1\163\1\165"+
        "\2\uffff\1\75\1\76\1\167\1\162\1\157\1\156\2\uffff\1\165\1\56\1"+
        "\145\1\162\1\76\1\75\2\uffff\2\75\1\174\1\uffff\1\75\1\40\1\145"+
        "\1\150\2\162\2\75\1\141\2\71\1\uffff\2\uffff\13\uffff\1\155\1\156"+
        "\1\167\1\154\2\uffff\1\160\2\172\2\uffff\1\172\1\163\1\164\1\171"+
        "\1\154\1\142\1\157\1\143\2\uffff\1\75\2\uffff\1\76\2\uffff\1\145"+
        "\1\147\1\161\1\160\1\151\1\145\1\155\1\163\1\145\1\172\1\164\1\163"+
        "\1\165\1\163\2\uffff\1\172\1\164\2\uffff\1\164\1\151\1\172\1\165"+
        "\21\uffff\1\100\1\uffff\4\uffff\1\164\1\151\1\162\1\157\1\154\1"+
        "\145\5\uffff\1\163\1\uffff\1\71\1\uffff\1\71\1\uffff\1\145\1\165"+
        "\1\172\1\154\1\157\1\uffff\1\165\1\164\1\uffff\1\157\1\uffff\1\164"+
        "\1\151\1\145\1\172\1\111\1\154\1\166\1\164\1\153\2\uffff\1\75\2"+
        "\uffff\1\143\1\156\1\165\1\145\1\164\1\163\1\141\1\160\1\145\1\141"+
        "\1\uffff\2\141\1\164\1\155\2\145\1\uffff\1\172\1\165\1\145\1\165"+
        "\1\163\1\uffff\1\145\1\uffff\1\uffff\1\uffff\1\uffff\1\172\1\154"+
        "\1\172\1\155\1\163\1\141\1\164\1\71\1\163\1\156\1\uffff\1\172\1"+
        "\162\1\164\1\141\1\143\1\162\1\166\1\160\1\uffff\1\156\1\151\1\141"+
        "\1\145\1\141\2\uffff\1\151\1\141\1\145\1\162\1\143\1\163\1\162\1"+
        "\157\1\172\2\164\1\165\1\162\2\172\1\162\1\uffff\1\146\1\143\1\151"+
        "\1\162\2\172\3\uffff\1\145\1\uffff\1\172\1\145\1\153\1\171\1\160"+
        "\1\151\1\uffff\1\164\1\172\1\156\1\172\1\141\1\151\1\164\1\163\1"+
        "\143\1\164\1\143\1\147\1\141\1\154\1\156\1\172\1\150\1\172\1\101"+
        "\1\163\1\uffff\1\145\1\171\1\154\1\157\2\uffff\1\145\1\151\1\145"+
        "\1\166\1\156\2\uffff\1\172\1\uffff\2\172\1\160\1\141\1\161\1\172"+
        "\1\uffff\1\143\1\uffff\1\143\1\172\1\164\1\172\1\164\1\172\1\145"+
        "\1\164\1\145\1\154\1\172\1\143\1\uffff\1\172\1\146\1\uffff\1\163"+
        "\1\145\1\114\1\160\1\164\1\171\1\144\1\156\1\172\1\145\1\172\2\uffff"+
        "\1\145\1\143\1\165\1\uffff\1\145\1\164\1\uffff\1\171\1\uffff\1\141"+
        "\1\uffff\1\172\1\145\1\172\1\151\1\uffff\1\145\1\uffff\1\171\1\163"+
        "\1\172\1\151\1\145\1\172\1\114\1\172\1\145\1\uffff\1\172\1\uffff"+
        "\1\172\2\145\1\157\2\172\1\156\1\uffff\1\144\1\uffff\3\172\1\157"+
        "\1\uffff\1\156\1\172\1\uffff\1\151\1\uffff\1\163\2\uffff\2\172\1"+
        "\146\2\uffff\1\143\1\172\1\145\2\uffff\1\143\1\153\1\uffff\1\156"+
        "\1\172\2\uffff\1\172\1\145\1\uffff\1\163\2\172\1\153\2\uffff\1\163"+
        "\1\172\2\uffff\2\172\3\uffff";
    static final String DFA25_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\2\uffff\1\10\4\uffff\1\20\1\21\6\uffff"+
        "\1\42\1\43\6\uffff\1\63\1\64\3\uffff\1\72\13\uffff\1\157\2\uffff"+
        "\1\164\1\165\1\144\1\1\1\2\1\3\1\4\1\5\1\6\1\140\1\37\4\uffff\1"+
        "\157\1\10\3\uffff\1\12\1\36\10\uffff\1\20\1\21\1\uffff\1\134\1\22"+
        "\1\uffff\1\135\1\23\16\uffff\1\42\1\43\2\uffff\1\47\1\52\4\uffff"+
        "\1\60\1\124\1\143\1\126\1\141\1\62\1\63\1\64\1\70\1\147\1\65\1\151"+
        "\1\66\1\71\1\150\1\67\1\72\2\uffff\1\145\1\127\1\74\1\164\6\uffff"+
        "\1\123\1\142\1\125\1\146\1\130\1\uffff\1\156\1\uffff\1\163\1\uffff"+
        "\1\160\5\uffff\1\77\2\uffff\1\107\1\uffff\1\13\11\uffff\1\152\1"+
        "\131\1\uffff\1\153\1\132\12\uffff\1\30\6\uffff\1\101\5\uffff\1\115"+
        "\2\uffff\1\162\1\uffff\1\161\12\uffff\1\55\10\uffff\1\41\5\uffff"+
        "\1\154\1\133\20\uffff\1\116\6\uffff\1\73\1\75\1\76\1\uffff\1\106"+
        "\6\uffff\1\57\24\uffff\1\103\4\uffff\1\33\1\100\5\uffff\1\53\1\155"+
        "\1\uffff\1\114\6\uffff\1\117\1\uffff\1\32\14\uffff\1\54\2\uffff"+
        "\1\26\13\uffff\1\105\1\110\3\uffff\1\11\2\uffff\1\27\1\uffff\1\112"+
        "\1\uffff\1\14\4\uffff\1\34\1\uffff\1\102\11\uffff\1\61\1\uffff\1"+
        "\111\7\uffff\1\15\1\uffff\1\17\4\uffff\1\40\2\uffff\1\104\1\uffff"+
        "\1\44\1\uffff\1\51\1\137\3\uffff\1\25\1\35\3\uffff\1\46\1\113\2"+
        "\uffff\1\31\2\uffff\1\7\1\45\2\uffff\1\16\4\uffff\1\50\1\136\2\uffff"+
        "\1\122\1\120\2\uffff\1\24\1\121\1\56";
    static final String DFA25_specialS =
        "\1\4\56\uffff\1\1\1\5\120\uffff\1\0\107\uffff\1\2\1\uffff\1\3\u00e1"+
        "\uffff}>";
    static final String[] DFA25_transitionS = {
            "\11\62\1\61\1\44\2\62\1\61\22\62\1\61\1\34\1\60\1\62\1\36\1"+
            "\52\1\37\1\57\1\3\1\4\1\1\1\51\1\5\1\33\1\30\1\43\1\54\11\55"+
            "\1\12\1\10\1\17\1\6\1\20\1\42\1\2\32\56\1\25\1\62\1\26\1\40"+
            "\1\56\1\62\1\13\1\50\1\22\1\23\1\24\1\47\1\56\1\53\1\11\2\56"+
            "\1\45\1\56\1\7\1\27\1\14\1\56\1\31\1\21\1\32\2\56\1\46\3\56"+
            "\1\15\1\41\1\16\1\35\uff81\62",
            "\1\63",
            "",
            "",
            "",
            "",
            "\1\72\1\71",
            "\1\74\3\uffff\1\76\11\uffff\1\75\5\uffff\1\77",
            "",
            "\1\103\6\uffff\1\102\1\104",
            "\1\105",
            "\1\110\1\111\10\uffff\1\113\1\uffff\1\112\4\uffff\1\107",
            "\1\116\20\uffff\1\115\2\uffff\1\114",
            "",
            "",
            "\1\121\1\122",
            "\1\125\1\124",
            "\1\131\3\uffff\1\130\6\uffff\1\127\4\uffff\1\132\1\uffff\1"+
            "\133",
            "\1\136\12\uffff\1\134\2\uffff\1\135\2\uffff\1\137",
            "\1\141\3\uffff\1\142\11\uffff\1\140",
            "\1\144\1\uffff\1\143",
            "",
            "",
            "\1\147\2\uffff\1\150",
            "\1\151",
            "\1\153",
            "\1\154\6\uffff\1\155\2\uffff\1\156",
            "\1\160\17\uffff\1\161\1\157",
            "\1\163",
            "",
            "",
            "\1\167\26\uffff\1\170",
            "\1\172",
            "\1\175\76\uffff\1\174",
            "",
            "\1\u0081\4\uffff\1\u0080\15\uffff\1\u0082",
            "\2\u0085\2\uffff\1\u0085\22\uffff\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u008a\15\uffff\1\u0088\2\uffff\1\u0089",
            "\1\u008b",
            "\1\u008c\21\uffff\1\u008d",
            "\1\u008f",
            "\1\u0091",
            "\10\u0093\2\u0094",
            "\12\u0095",
            "",
            "\0\100",
            "\0\u0096",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "",
            "",
            "\1\u009b",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\16\100\1\u009d"+
            "\3\100\1\u009e\7\100",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\22\100\1\u00a0"+
            "\7\100",
            "\1\u00a2",
            "\1\u00a4\20\uffff\1\u00a3",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8\5\uffff\1\u00a9",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "",
            "",
            "\1\u00ae\1\u00ad",
            "",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5\3\uffff\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00bb",
            "\1\u00bc\14\uffff\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\3\100\1\u00c0"+
            "\26\100",
            "\1\u00c2",
            "",
            "",
            "\1\u00c4\1\u00c3\17\uffff\1\u00c5",
            "\1\u00c6",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00c8",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c9",
            "\100\u00cc\1\u00cb\uffbf\u00cc",
            "",
            "",
            "",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "",
            "",
            "",
            "",
            "",
            "\1\u00d3",
            "",
            "\10\u00d4\2\u0094",
            "",
            "\12\u0095",
            "",
            "\1\u00d5",
            "\1\u00d6",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "",
            "",
            "\1\u00e6",
            "",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u00f9\17\uffff\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\0\u00ca",
            "",
            "\0\u00cc",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0102",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\10\u00d4\2\u0094",
            "\1\u0108",
            "\1\u0109",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "",
            "",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0126",
            "",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "",
            "\1\u012d",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "",
            "\1\u0134",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0136",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0138",
            "\1\u0139\3\uffff\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0145",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\10\100\1\u0146"+
            "\21\100",
            "\1\u0148",
            "\1\u0149",
            "",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "",
            "",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\1\u0159",
            "",
            "\1\u015a",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u015c",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u015e",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0165",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0167",
            "",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0171",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "\1\u0177",
            "",
            "\1\u0178",
            "",
            "\1\u0179",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u017b",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u017d",
            "",
            "\1\u017e",
            "",
            "\1\u017f",
            "\1\u0180",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0182",
            "\1\u0183",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0185",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0187",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u018f",
            "",
            "\1\u0190",
            "",
            "\1\u0191",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u0194",
            "",
            "\1\u0195",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "\1\u0197",
            "",
            "\1\u0198",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u019b",
            "",
            "",
            "\1\u019c",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u019e",
            "",
            "",
            "\1\u019f",
            "\1\u01a0",
            "",
            "\1\u01a1",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u01a4",
            "",
            "\1\u01a5",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\1\u01a8",
            "",
            "",
            "\1\u01a9",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "\12\100\7\uffff\32\100\4\uffff\1\100\1\uffff\32\100",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | RULE_BOOLEAN_VALUE | RULE_INTEGER_VALUE | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_INT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_129 = input.LA(1);

                        s = -1;
                        if ( (LA25_129=='@') ) {s = 203;}

                        else if ( ((LA25_129>='\u0000' && LA25_129<='?')||(LA25_129>='A' && LA25_129<='\uFFFF')) ) {s = 204;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_47 = input.LA(1);

                        s = -1;
                        if ( ((LA25_47>='\u0000' && LA25_47<='\uFFFF')) ) {s = 64;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_201 = input.LA(1);

                        s = -1;
                        if ( ((LA25_201>='\u0000' && LA25_201<='\uFFFF')) ) {s = 202;}

                        else s = 255;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA25_203 = input.LA(1);

                        s = -1;
                        if ( ((LA25_203>='\u0000' && LA25_203<='\uFFFF')) ) {s = 204;}

                        else s = 256;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0=='*') ) {s = 1;}

                        else if ( (LA25_0=='@') ) {s = 2;}

                        else if ( (LA25_0=='(') ) {s = 3;}

                        else if ( (LA25_0==')') ) {s = 4;}

                        else if ( (LA25_0==',') ) {s = 5;}

                        else if ( (LA25_0=='=') ) {s = 6;}

                        else if ( (LA25_0=='n') ) {s = 7;}

                        else if ( (LA25_0==';') ) {s = 8;}

                        else if ( (LA25_0=='i') ) {s = 9;}

                        else if ( (LA25_0==':') ) {s = 10;}

                        else if ( (LA25_0=='a') ) {s = 11;}

                        else if ( (LA25_0=='p') ) {s = 12;}

                        else if ( (LA25_0=='{') ) {s = 13;}

                        else if ( (LA25_0=='}') ) {s = 14;}

                        else if ( (LA25_0=='<') ) {s = 15;}

                        else if ( (LA25_0=='>') ) {s = 16;}

                        else if ( (LA25_0=='s') ) {s = 17;}

                        else if ( (LA25_0=='c') ) {s = 18;}

                        else if ( (LA25_0=='d') ) {s = 19;}

                        else if ( (LA25_0=='e') ) {s = 20;}

                        else if ( (LA25_0=='[') ) {s = 21;}

                        else if ( (LA25_0==']') ) {s = 22;}

                        else if ( (LA25_0=='o') ) {s = 23;}

                        else if ( (LA25_0=='.') ) {s = 24;}

                        else if ( (LA25_0=='r') ) {s = 25;}

                        else if ( (LA25_0=='t') ) {s = 26;}

                        else if ( (LA25_0=='-') ) {s = 27;}

                        else if ( (LA25_0=='!') ) {s = 28;}

                        else if ( (LA25_0=='~') ) {s = 29;}

                        else if ( (LA25_0=='$') ) {s = 30;}

                        else if ( (LA25_0=='&') ) {s = 31;}

                        else if ( (LA25_0=='^') ) {s = 32;}

                        else if ( (LA25_0=='|') ) {s = 33;}

                        else if ( (LA25_0=='?') ) {s = 34;}

                        else if ( (LA25_0=='/') ) {s = 35;}

                        else if ( (LA25_0=='\n') ) {s = 36;}

                        else if ( (LA25_0=='l') ) {s = 37;}

                        else if ( (LA25_0=='w') ) {s = 38;}

                        else if ( (LA25_0=='f') ) {s = 39;}

                        else if ( (LA25_0=='b') ) {s = 40;}

                        else if ( (LA25_0=='+') ) {s = 41;}

                        else if ( (LA25_0=='%') ) {s = 42;}

                        else if ( (LA25_0=='h') ) {s = 43;}

                        else if ( (LA25_0=='0') ) {s = 44;}

                        else if ( ((LA25_0>='1' && LA25_0<='9')) ) {s = 45;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||LA25_0=='g'||(LA25_0>='j' && LA25_0<='k')||LA25_0=='m'||LA25_0=='q'||(LA25_0>='u' && LA25_0<='v')||(LA25_0>='x' && LA25_0<='z')) ) {s = 46;}

                        else if ( (LA25_0=='\'') ) {s = 47;}

                        else if ( (LA25_0=='\"') ) {s = 48;}

                        else if ( (LA25_0=='\t'||LA25_0=='\r'||LA25_0==' ') ) {s = 49;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='#'||LA25_0=='\\'||LA25_0=='`'||(LA25_0>='\u007F' && LA25_0<='\uFFFF')) ) {s = 50;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA25_48 = input.LA(1);

                        s = -1;
                        if ( ((LA25_48>='\u0000' && LA25_48<='\uFFFF')) ) {s = 150;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
