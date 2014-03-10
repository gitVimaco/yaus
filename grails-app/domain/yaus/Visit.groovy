package yaus

class Visit {
    static belongsTo = [link: Link]
    Date dateCreated
    String ip

    static constraints = {
        ip nullable: true
    }
}
