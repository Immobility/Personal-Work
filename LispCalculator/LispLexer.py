import ply.lex as lex

reserved = {'car' : 'CAR', 'cdr' : 'CDR', 'cons' : 'CONS', 'let' : 'LET'}

tokens = ['LPAREN', 'RPAREN', 'NAME', 'NUMBER', 'ADD', 'SUB', 'DIV', 'MUL'] + \
    list(reserved.values())

t_LPAREN = r'\('
t_RPAREN = r'\)'
t_ADD = r'\+'
t_SUB = r'\-'
t_DIV = r'\/'
t_MUL = r'\*'


def t_NAME(t):
    r'((?!car|cdr|cons|let)[a-zA-Z_][a-zA-Z0-9_]*)'
    t.type = 'NAME'
    return t

def t_CAR(t):
    r'\b(car)\b'
    t.type = 'CAR'
    return t

def t_CDR(t): 
    r'\b(cdr)\b' 
    t.type = 'CDR' 
    return t

def t_CONS(t): 
    r'\b(cons)\b' 
    t.type = 'CONS' 
    return t

def t_LET(t): 
    r'\b(let)\b' 
    t.type = 'LET' 
    return t

def t_NUMBER(t):
    r'\b[0-9]+(\.[0-9]*)?\b'
    t.type = 'NUMBER'
    return t

# Ignored characters
t_ignore = " \r\n\t"
t_ignore_COMMENT = r'\#.*'
t_ignore_SEMI = r';'

def t_error(t):
    print("Illegal character '%s'" % t.value[0])
    raise Exception('LEXER ERROR')


lexer = lex.lex()

#data = '(LET ((as 100)))'


#
## Give the lexer some input
#print("Tokenizing: ", data)
#lexer.input(data)
#
## Tokenize
#while True:
#    tok = lexer.token()
#    if not tok:
##        break      # No more input
#    print(tok)
