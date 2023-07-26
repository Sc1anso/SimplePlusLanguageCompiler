push 0
push 1
push function0
lfp
push 6
push -2
lfp
add
lw
lfp
push -3
lfp
add
lw
js
halt

function0:
cfp
lra
push 2
lfp
add
lw
push 0
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 1
lfp
add
lw
push 2
lfp
add
lw
mult
lfp
push 2
lfp
add
lw
push 1
sub
push -2
lfp
add
lw
lfp
lw
push -3
lfp
lw
add
lw
js
b label1
label0:
push 1
lfp
add
lw
print
label1:
push 1
lfp
add
lw
del
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
