// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g 2011-05-19 23:06:35

package aspectsjlo.input;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class JavaL extends Lexer {
    public static final int EOF=-1;
    public static final int HexDigit=4;
    public static final int IntegerTypeSuffix=5;
    public static final int HexLiteral=6;
    public static final int DecimalLiteral=7;
    public static final int OctalLiteral=8;
    public static final int Exponent=9;
    public static final int FloatTypeSuffix=10;
    public static final int FloatingPointLiteral=11;
    public static final int EscapeSequence=12;
    public static final int CharacterLiteral=13;
    public static final int StringLiteral=14;
    public static final int UnicodeEscape=15;
    public static final int OctalEscape=16;
    public static final int ENUM=17;
    public static final int ASSERT=18;
    public static final int Letter=19;
    public static final int JavaIDDigit=20;
    public static final int Identifier=21;
    public static final int WS=22;
    public static final int COMMENT=23;
    public static final int LINE_COMMENT=24;

      protected boolean enumIsKeyword = true;
      protected boolean assertIsKeyword = true;


    // delegates
    // delegators

    public JavaL() {;} 
    public JavaL(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JavaL(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g"; }

    // $ANTLR start "HexLiteral"
    public final void mHexLiteral() throws RecognitionException {
        try {
            int _type = HexLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:12: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:14: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:28: ( HexDigit )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='F')||(LA1_0>='a' && LA1_0<='f')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:28: HexDigit
            	    {
            	    mHexDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:38: ( IntegerTypeSuffix )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='L'||LA2_0=='l') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:11:38: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

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
    // $ANTLR end "HexLiteral"

    // $ANTLR start "DecimalLiteral"
    public final void mDecimalLiteral() throws RecognitionException {
        try {
            int _type = DecimalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:16: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:18: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:18: ( '0' | '1' .. '9' ( '0' .. '9' )* )
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:19: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:25: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:34: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:34: '0' .. '9'
                    	    {
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

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:45: ( IntegerTypeSuffix )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='L'||LA5_0=='l') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:13:45: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

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
    // $ANTLR end "DecimalLiteral"

    // $ANTLR start "OctalLiteral"
    public final void mOctalLiteral() throws RecognitionException {
        try {
            int _type = OctalLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:14: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:16: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            {
            match('0'); 
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:20: ( '0' .. '7' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='7')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:21: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:32: ( IntegerTypeSuffix )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='L'||LA7_0=='l') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:15:32: IntegerTypeSuffix
                    {
                    mIntegerTypeSuffix(); 

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
    // $ANTLR end "OctalLiteral"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:18:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:18:12: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "IntegerTypeSuffix"
    public final void mIntegerTypeSuffix() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:21:19: ( ( 'l' | 'L' ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:21:21: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "IntegerTypeSuffix"

    // $ANTLR start "FloatingPointLiteral"
    public final void mFloatingPointLiteral() throws RecognitionException {
        try {
            int _type = FloatingPointLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix )
            int alt18=4;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                    {
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    match('.'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:25: ( '0' .. '9' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:37: ( Exponent )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='E'||LA10_0=='e') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:37: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:47: ( FloatTypeSuffix )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='D'||LA11_0=='F'||LA11_0=='d'||LA11_0=='f') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:24:47: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                    {
                    match('.'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:13: ( '0' .. '9' )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:14: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:25: ( Exponent )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0=='E'||LA13_0=='e') ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:25: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:35: ( FloatTypeSuffix )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='D'||LA14_0=='F'||LA14_0=='d'||LA14_0=='f') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:25:35: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:26:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                    {
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:26:9: ( '0' .. '9' )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:26:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    mExponent(); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:26:30: ( FloatTypeSuffix )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='D'||LA16_0=='F'||LA16_0=='d'||LA16_0=='f') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:26:30: FloatTypeSuffix
                            {
                            mFloatTypeSuffix(); 

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:27:9: ( '0' .. '9' )+ FloatTypeSuffix
                    {
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:27:9: ( '0' .. '9' )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:27:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    mFloatTypeSuffix(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FloatingPointLiteral"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:31:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:31:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:31:22: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:31:33: ( '0' .. '9' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:31:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "FloatTypeSuffix"
    public final void mFloatTypeSuffix() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:34:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:34:19: ( 'f' | 'F' | 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='d'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "FloatTypeSuffix"

    // $ANTLR start "CharacterLiteral"
    public final void mCharacterLiteral() throws RecognitionException {
        try {
            int _type = CharacterLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:37:5: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:37:9: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:37:14: ( EscapeSequence | ~ ( '\\'' | '\\\\' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                alt21=1;
            }
            else if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:37:16: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:37:33: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CharacterLiteral"

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:41:5: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:41:8: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:41:12: ( EscapeSequence | ~ ( '\\\\' | '\"' ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\\') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='!')||(LA22_0>='#' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFF')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:41:14: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:41:31: ~ ( '\\\\' | '\"' )
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
            	    break loop22;
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
    // $ANTLR end "StringLiteral"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:46:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UnicodeEscape | OctalEscape )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt23=1;
                    }
                    break;
                case 'u':
                    {
                    alt23=2;
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
                    {
                    alt23=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:46:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:47:9: UnicodeEscape
                    {
                    mUnicodeEscape(); 

                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:48:9: OctalEscape
                    {
                    mOctalEscape(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "OctalEscape"
    public final void mOctalEscape() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\\') ) {
                int LA24_1 = input.LA(2);

                if ( ((LA24_1>='0' && LA24_1<='3')) ) {
                    int LA24_2 = input.LA(3);

                    if ( ((LA24_2>='0' && LA24_2<='7')) ) {
                        int LA24_4 = input.LA(4);

                        if ( ((LA24_4>='0' && LA24_4<='7')) ) {
                            alt24=1;
                        }
                        else {
                            alt24=2;}
                    }
                    else {
                        alt24=3;}
                }
                else if ( ((LA24_1>='4' && LA24_1<='7')) ) {
                    int LA24_3 = input.LA(3);

                    if ( ((LA24_3>='0' && LA24_3<='7')) ) {
                        alt24=2;
                    }
                    else {
                        alt24=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:14: ( '0' .. '3' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:25: ( '0' .. '7' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:36: ( '0' .. '7' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:53:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:54:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:54:14: ( '0' .. '7' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:54:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:54:25: ( '0' .. '7' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:54:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:55:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:55:14: ( '0' .. '7' )
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:55:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OctalEscape"

    // $ANTLR start "UnicodeEscape"
    public final void mUnicodeEscape() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:60:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:60:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            {
            match('\\'); 
            match('u'); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 
            mHexDigit(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeEscape"

    // $ANTLR start "ENUM"
    public final void mENUM() throws RecognitionException {
        try {
            int _type = ENUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:63:5: ( 'enum' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:63:9: 'enum'
            {
            match("enum"); 

            if (!enumIsKeyword) _type=Identifier;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUM"

    // $ANTLR start "ASSERT"
    public final void mASSERT() throws RecognitionException {
        try {
            int _type = ASSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:67:5: ( 'assert' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:67:9: 'assert'
            {
            match("assert"); 

            if (!assertIsKeyword) _type=Identifier;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSERT"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:71:5: ( Letter ( Letter | JavaIDDigit )* )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:71:9: Letter ( Letter | JavaIDDigit )*
            {
            mLetter(); 
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:71:16: ( Letter | JavaIDDigit )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0=='$'||(LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')||(LA25_0>='\u00C0' && LA25_0<='\u00D6')||(LA25_0>='\u00D8' && LA25_0<='\u00F6')||(LA25_0>='\u00F8' && LA25_0<='\u1FFF')||(LA25_0>='\u3040' && LA25_0<='\u318F')||(LA25_0>='\u3300' && LA25_0<='\u337F')||(LA25_0>='\u3400' && LA25_0<='\u3D2D')||(LA25_0>='\u4E00' && LA25_0<='\u9FFF')||(LA25_0>='\uF900' && LA25_0<='\uFAFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:79:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00D6')||(input.LA(1)>='\u00D8' && input.LA(1)<='\u00F6')||(input.LA(1)>='\u00F8' && input.LA(1)<='\u1FFF')||(input.LA(1)>='\u3040' && input.LA(1)<='\u318F')||(input.LA(1)>='\u3300' && input.LA(1)<='\u337F')||(input.LA(1)>='\u3400' && input.LA(1)<='\u3D2D')||(input.LA(1)>='\u4E00' && input.LA(1)<='\u9FFF')||(input.LA(1)>='\uF900' && input.LA(1)<='\uFAFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "JavaIDDigit"
    public final void mJavaIDDigit() throws RecognitionException {
        try {
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:96:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='\u0660' && input.LA(1)<='\u0669')||(input.LA(1)>='\u06F0' && input.LA(1)<='\u06F9')||(input.LA(1)>='\u0966' && input.LA(1)<='\u096F')||(input.LA(1)>='\u09E6' && input.LA(1)<='\u09EF')||(input.LA(1)>='\u0A66' && input.LA(1)<='\u0A6F')||(input.LA(1)>='\u0AE6' && input.LA(1)<='\u0AEF')||(input.LA(1)>='\u0B66' && input.LA(1)<='\u0B6F')||(input.LA(1)>='\u0BE7' && input.LA(1)<='\u0BEF')||(input.LA(1)>='\u0C66' && input.LA(1)<='\u0C6F')||(input.LA(1)>='\u0CE6' && input.LA(1)<='\u0CEF')||(input.LA(1)>='\u0D66' && input.LA(1)<='\u0D6F')||(input.LA(1)>='\u0E50' && input.LA(1)<='\u0E59')||(input.LA(1)>='\u0ED0' && input.LA(1)<='\u0ED9')||(input.LA(1)>='\u1040' && input.LA(1)<='\u1049') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "JavaIDDigit"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:113:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:113:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:117:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:117:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:117:14: ( options {greedy=false; } : . )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0=='*') ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1=='/') ) {
                        alt26=2;
                    }
                    else if ( ((LA26_1>='\u0000' && LA26_1<='.')||(LA26_1>='0' && LA26_1<='\uFFFF')) ) {
                        alt26=1;
                    }


                }
                else if ( ((LA26_0>='\u0000' && LA26_0<=')')||(LA26_0>='+' && LA26_0<='\uFFFF')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:117:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:12: (~ ( '\\n' | '\\r' ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='\u0000' && LA27_0<='\t')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\uFFFF')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:12: ~ ( '\\n' | '\\r' )
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
            	    break loop27;
                }
            } while (true);

            // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:26: ( '\\r' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='\r') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:121:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:8: ( HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | ENUM | ASSERT | Identifier | WS | COMMENT | LINE_COMMENT )
        int alt29=12;
        alt29 = dfa29.predict(input);
        switch (alt29) {
            case 1 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:10: HexLiteral
                {
                mHexLiteral(); 

                }
                break;
            case 2 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:21: DecimalLiteral
                {
                mDecimalLiteral(); 

                }
                break;
            case 3 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:36: OctalLiteral
                {
                mOctalLiteral(); 

                }
                break;
            case 4 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:49: FloatingPointLiteral
                {
                mFloatingPointLiteral(); 

                }
                break;
            case 5 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:70: CharacterLiteral
                {
                mCharacterLiteral(); 

                }
                break;
            case 6 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:87: StringLiteral
                {
                mStringLiteral(); 

                }
                break;
            case 7 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:101: ENUM
                {
                mENUM(); 

                }
                break;
            case 8 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:106: ASSERT
                {
                mASSERT(); 

                }
                break;
            case 9 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:113: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 10 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:124: WS
                {
                mWS(); 

                }
                break;
            case 11 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:127: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 12 :
                // C:\\GIT\\aspects-jlo\\src\\aspectsjlo\\input\\JavaL.g:1:135: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA18_eotS =
        "\6\uffff";
    static final String DFA18_eofS =
        "\6\uffff";
    static final String DFA18_minS =
        "\2\56\4\uffff";
    static final String DFA18_maxS =
        "\1\71\1\146\4\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\1\1\3\1\4";
    static final String DFA18_specialS =
        "\6\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5\1\4\1"+
            "\5",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "23:1: FloatingPointLiteral : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ FloatTypeSuffix );";
        }
    }
    static final String DFA29_eotS =
        "\1\uffff\2\14\3\uffff\2\10\5\uffff\1\23\1\14\2\10\3\uffff\2\10"+
        "\1\30\1\10\1\uffff\1\10\1\33\1\uffff";
    static final String DFA29_eofS =
        "\34\uffff";
    static final String DFA29_minS =
        "\1\11\2\56\3\uffff\1\156\1\163\2\uffff\1\52\2\uffff\2\56\1\165"+
        "\1\163\3\uffff\1\155\1\145\1\44\1\162\1\uffff\1\164\1\44\1\uffff";
    static final String DFA29_maxS =
        "\1\ufaff\1\170\1\146\3\uffff\1\156\1\163\2\uffff\1\57\2\uffff\2"+
        "\146\1\165\1\163\3\uffff\1\155\1\145\1\ufaff\1\162\1\uffff\1\164"+
        "\1\ufaff\1\uffff";
    static final String DFA29_acceptS =
        "\3\uffff\1\4\1\5\1\6\2\uffff\1\11\1\12\1\uffff\1\1\1\2\4\uffff"+
        "\1\13\1\14\1\3\4\uffff\1\7\2\uffff\1\10";
    static final String DFA29_specialS =
        "\34\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\11\1\uffff\2\11\22\uffff\1\11\1\uffff\1\5\1\uffff\1\10\2"+
            "\uffff\1\4\6\uffff\1\3\1\12\1\1\11\2\7\uffff\32\10\4\uffff\1"+
            "\10\1\uffff\1\7\3\10\1\6\25\10\105\uffff\27\10\1\uffff\37\10"+
            "\1\uffff\u1f08\10\u1040\uffff\u0150\10\u0170\uffff\u0080\10"+
            "\u0080\uffff\u092e\10\u10d2\uffff\u5200\10\u5900\uffff\u0200"+
            "\10",
            "\1\3\1\uffff\10\15\2\3\12\uffff\3\3\21\uffff\1\13\13\uffff"+
            "\3\3\21\uffff\1\13",
            "\1\3\1\uffff\12\16\12\uffff\3\3\35\uffff\3\3",
            "",
            "",
            "",
            "\1\17",
            "\1\20",
            "",
            "",
            "\1\21\4\uffff\1\22",
            "",
            "",
            "\1\3\1\uffff\10\15\2\3\12\uffff\3\3\35\uffff\3\3",
            "\1\3\1\uffff\12\16\12\uffff\3\3\35\uffff\3\3",
            "\1\24",
            "\1\25",
            "",
            "",
            "",
            "\1\26",
            "\1\27",
            "\1\10\13\uffff\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff\32"+
            "\10\105\uffff\27\10\1\uffff\37\10\1\uffff\u1f08\10\u1040\uffff"+
            "\u0150\10\u0170\uffff\u0080\10\u0080\uffff\u092e\10\u10d2\uffff"+
            "\u5200\10\u5900\uffff\u0200\10",
            "\1\31",
            "",
            "\1\32",
            "\1\10\13\uffff\12\10\7\uffff\32\10\4\uffff\1\10\1\uffff\32"+
            "\10\105\uffff\27\10\1\uffff\37\10\1\uffff\u1f08\10\u1040\uffff"+
            "\u0150\10\u0170\uffff\u0080\10\u0080\uffff\u092e\10\u10d2\uffff"+
            "\u5200\10\u5900\uffff\u0200\10",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( HexLiteral | DecimalLiteral | OctalLiteral | FloatingPointLiteral | CharacterLiteral | StringLiteral | ENUM | ASSERT | Identifier | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}