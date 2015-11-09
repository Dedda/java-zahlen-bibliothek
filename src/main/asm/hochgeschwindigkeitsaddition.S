.section .text
.global hochgeschwindigkeitsaddition
hochgeschwindigkeitsaddition:
    push %ebp
    mov %esp, %ebp
    mov 8(%ebp), %ecx
    mov 12(%ebp), %edx
    add %edx, %ecx
    mov %ecx, %eax
    mov %ebp, %esp
    pop %ebp
    ret