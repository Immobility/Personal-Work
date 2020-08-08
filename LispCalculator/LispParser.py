import ply.yacc as yacc
from LispLexer import tokens

class EmptyListError(Exception):
    """List is empty!"""
    pass


precedence = (
        ('left', 'ADD', 'SUB'),
        ('left', 'MUL', 'DIV'),
        )
names = {}
lists = []

def p_statement_assign(t):
    'statement : LPAREN LET LPAREN expression RPAREN RPAREN'
    t[0] = t[4]

def p_statement_expr(t):
    'statement : expression'
    print(t[1])

def p_statement_list(t):
    'statement : list'
    print(t[1])

def p_expression_binop(t):
    '''expression : LPAREN ADD expression expression RPAREN
                  | LPAREN SUB expression expression RPAREN
                  | LPAREN MUL expression expression RPAREN
                  | LPAREN DIV expression expression RPAREN'''
    if t[2] == '+'  : t[0] = int(t[3]) + int(t[4])
    elif t[2] == '-': t[0] = int(t[3]) - int(t[4])
    elif t[2] == '*': t[0] = int(t[3]) * int(t[4])
    elif t[2] == '/': 
            try:
                t[0] = int(t[3]) / int(t[4])
            except  ZeroDivisionError:
                print("Divide by zero!")
    
    else:
        print("Syntax error in binary operation input!")
        parser.token()
        parser.restart()


def p_expression_group1(t):
    'expression : LPAREN NAME NUMBER RPAREN'
    names[t[2]] = t[3]

def p_expression_group2(t):
    'expression : LPAREN NAME NUMBER RPAREN expression'
    names[t[2]] = t[3]

def p_expression_number(t):
    'expression : NUMBER'
    t[0] = t[1]

def p_expression_name(t):
    'expression : NAME'
    try:
        t[0] = names[t[1]]
        print(names)
    except LookupError:
        print("Undefined var '%s'" % t[1])
        t[0] = 0

def p_expression_list(t):
    'list : LPAREN alist RPAREN'
    for x in t[2]:
        lists.append(x)

def p_expression_alist1(t):
    'alist : expression'
    t[0] = t[1]

def p_expression_alist2(t):
    'alist : expression alist'
    t[0] = t[1] + t[2]

def p_list_op(t):
    '''expression : LPAREN CAR list RPAREN   
                  | LPAREN CDR list RPAREN   
                  | LPAREN CONS expression list RPAREN'''

    if t[2] == 'car'    : 
        try:
            t[0] = lists[0]
        except EmptyListError:
            print("List is empty!")
            

    elif t[2] == "cdr"  : 
        try:
            t[0] = lists[1:]
        except EmptyListError:
            print("List is empty!")
    
    elif t[2] == "cons" : lists.insert(0, t[3]); t[0] = lists

def p_error(p):
    print("Syntax error in input!")

parser = yacc.yacc()

