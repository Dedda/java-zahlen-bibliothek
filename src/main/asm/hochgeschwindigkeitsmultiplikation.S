.section .text
.global hochgeschwindigkeitsmultiplikation
hochgeschwindigkeitsmultiplikation:
    push %ebp
    mov %esp, %ebp
    mov 8(%ebp), %ecx
    mov 12(%ebp), %edx
    imul %edx, %ecx
    mov %ecx, %eax
    mov %ebp, %esp
    pop %ebp
    ret